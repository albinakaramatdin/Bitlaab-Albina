 function calculateEquation() {
        
            var x = parseFloat(prompt("Введите значение x:", ""));

            if (isNaN(x)) {
                alert("Пожалуйста, введите числовое значение.");
                return;
            }

            var y = x*x + 2*x - 1;

            alert("Вывод y = " + y);
        }