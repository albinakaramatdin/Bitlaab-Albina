function getAlert() {
	alert("Hello");
}

function check() {
		let summa = document.getElementById("summa").value; 
		let x = document.getElementById("convert").value;

		let dollar = 429;
		let euro = 507;
		let resultDollar;
		let resultEuro;

		if (x==="KZT") {
			resultDollar = parseInt(summa/dollar);
			resultEuro = parseInt(summa/euro);
			document.getElementById("USD").value=resultDollar;
			document.getElementById("EUR").value=resultEuro;
			document.getElementById("KZT").value="-";
		}
	}