function checkArrivalTime() {
            
            var speed = parseFloat(prompt("Введите скорость вашей машины (км/ч):", ""));
            var distance = parseFloat(prompt("Введите расстояние между вами и Актобе (км):", ""));

            
            if (isNaN(speed) || isNaN(distance)) {
                alert("Пожалуйста, введите числовые значения.");
                return;
            }

            
            var timeLeft = 18 - 15 - 45 / 60; 

            
            var travelTime = distance / speed;

            
            if (travelTime <= timeLeft) {
                alert("YES, YOU CAN REACH");
            } else {
                alert("NO, YOU CAN NOT REACH");
            }
        }