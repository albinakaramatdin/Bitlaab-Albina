 function distributeApples() {

            var n = parseInt(prompt("Введите количество школьников n:", ""));
            var k = parseInt(prompt("Введите количество яблок k:", ""));

            if (isNaN(n) || isNaN(k)) {
                alert("Пожалуйста, введите значения.");
                return;
            }

            var applesPerStudent = Math.floor(k / n);

            alert("Каждому школьнику достанется " + applesPerStudent + " яблок.");
        }