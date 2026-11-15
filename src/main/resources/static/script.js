const operationButtons = document.querySelectorAll(".operation");

const sendButton = document.getElementById("send");
const clearButton = document.getElementById("clear");

const number1 = document.getElementById("number1")
const number2 = document.getElementById("number2")
const result = document.getElementById("result")

let selectedOperation = null

operationButtons.forEach(button => {
  button.addEventListener("click", () => {

      operationButtons.forEach(btn => btn.classList.remove("selected"))

      button.classList.add("selected")
      selectedOperation = button.dataset.operation
    })
})

sendButton.addEventListener("click", async () => {
    if (
        number1.value === "" || number2.value === "" ||
        !number1.checkValidity() || !number2.checkValidity() ||
        selectedOperation == null
    ) {
        result.textContent = "Preencha os números e escolha uma operação."
        return;
    }

    const requestBody = {
        number1: Number(number1.value),
        number2: Number(number2.value)
    }

    try {
        const response = await fetch(
            `/api/calculator/${selectedOperation}`,
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(requestBody)
            }
        );

        if (!response.ok) {
            throw new Error("Erro ao realizar o cálculo.");
        }

        const data = await response.json();

        result.textContent = data.message ??
            `Resultado: ${data.result}`;

    } catch (error) {
        result.textContent = error.message;
    }
})

clearButton.addEventListener("click", () => {
    number1.value = "";
    number2.value = "";

    selectedOperation = null;

    operationButtons.forEach(button => {
        button.classList.remove("selected");
    });

    result.textContent = "Resultado aparecerá aqui";
});