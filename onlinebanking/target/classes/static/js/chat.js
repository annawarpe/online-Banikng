function loadMessages(){

fetch("http://localhost:8080/api/messages")
.then(r=>r.json())
.then(data=>{

let box=document.getElementById("chatBox");
box.innerHTML="";

data.forEach(m=>{
box.innerHTML+=`<p><b>${m.sender}:</b> ${m.content}</p>`;
});

box.scrollTop=box.scrollHeight;

});
}

setInterval(loadMessages,2000);
loadMessages();
