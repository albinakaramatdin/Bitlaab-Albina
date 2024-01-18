 function performOperations() {
            var a = parseInt(prompt("Введите a:", ""));
            var b = parseInt(prompt("Введите b:", ""));
            var c = parseInt(prompt("Введите c:", ""));

    
            if (isNaN(a) || isNaN(b) || isNaN(c)) {
                alert("Введите значения.");
                return;
            }

            var sum = a + b + c;
            var difference = a - b - c;
            var product = a * b * c;

            alert("a + b + c = " + sum + "\na – b – c = " + difference + "\na * b * c = " + product);
        }