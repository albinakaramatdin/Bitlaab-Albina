function check() {

        let summa = document.getElementById("summa").value;
        let x = document.getElementById("convert").value;

        let dollar = 429;
        let euro = 507;
        let pdollar = 431;
        let peuro = 509;
        let resultDollar;
        let resultEuro;
        let resultTenge;

        if (x=="KZT"){
            resultDollar = parseInt(summa/pdollar);
            resultEuro = parseInt(summa/peuro);
            document.getElementById("usd").value = resultDollar;
            document.getElementById("eur").value = resultEuro;
            document.getElementById("kzt").value = "-";
        } else if (x=="USD"){
            resultTenge = parseInt(summa*dollar);
            resultEuro = parseInt(resultTenge/peuro);
            document.getElementById("usd").value = "-";
            document.getElementById("eur").value = resultEuro;
            document.getElementById("kzt").value = resultTenge;
        } else {
            resultTenge = parseInt(summa*euro);
            resultDollar = parseInt(resultTenge/pdollar);
            document.getElementById("usd").value = resultDollar;
            document.getElementById("eur").value = "-";
            document.getElementById("kzt").value = resultTenge;
        }



    }