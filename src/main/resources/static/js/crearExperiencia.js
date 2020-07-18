var inputL = document.getElementById("logros");

inputL.addEventListener("input",function(){
    if(this.value.length > 30){
        document.getElementById("Logros20").style.display = "block";
        console.log(this.value);
        
    }
    else{
        document.getElementById("Logros20").style.display = "none";
        console.log(this.value);
    }
}); 

inputL.addEventListener("focus",function(){
    if(this.value == "Accion => Resultado"){
        this.value = "";
        console.log(this.value);
    }else{
        this.value = this.value;
    }

});
