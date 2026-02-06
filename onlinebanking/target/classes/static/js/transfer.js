document.addEventListener("DOMContentLoaded", function () {
    const transferBtn = document.querySelector("#transfer button");

    transferBtn.addEventListener("click", function () {
        const from = document.querySelector("#transfer select").value;
        const toAccount = document.querySelectorAll("#transfer input[type=number]")[0].value;
        const amount = document.querySelectorAll("#transfer input[type=number]")[1].value;

        if(!from || !toAccount || !amount){
            alert("Please fill all fields!");
            return;
        }

        fetch(`/api/transfer?fromAccount=${encodeURIComponent(from)}&toAccountNumber=${toAccount}&amount=${amount}`, {
            method: "POST"
        })
        .then(res => res.text())
        .then(data => alert(data))
        .catch(err => console.error(err));
    });
});
