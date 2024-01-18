function checkDivisibility() {

            var a = parseInt(prompt("Введите значение a:", ""));
            var b = parseInt(prompt("Введите значение b:", ""));

            if (isNaN(a) || isNaN(b)) {
                alert("Пожалуйста, введите значения.");
                return;
            }

            if (a % b === 0) {
                alert("Divisible");
            } else {
                alert("Not Divisible");
            }
        }