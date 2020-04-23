function validate() {
    let name=document.getElementById("name").value;
    let area=document.getElementById("area").value;
    let gdp=document.getElementById("gdp").value;
    let population=document.getElementById("population").value;
    let description=document.getElementById("description").value;

    if (name===""){
        alert("name not null");
        return false;
    }
    if (area===""){
        alert("area not null");
        return  false;
    }
    if (!area.parseFloat()){
        alert("are not number");
        return  false;
    }else if (area.parseInt()<0){
        alert("are not min 0");
        return  false;
    }

    if (gdp===""){
        alert("gdp not null");
        return false;
    }
    if (!gdp.parseFloat()){
        alert("gdp not number");
        return  false;
    }else if (gdp.parseInt()<0){
        alert("gdp not min 0");
        return  false;
    }
    if (population===""){
        alert("population not null");
        return false;
    }
    if (!population.parseFloat()){
        alert("population not number");
        return  false;
    }else if (population.parseInt()<0){
        alert("population not min 0");
        return  false;
    }

    if (description===""){
        alert("description not null");
        return false;
    }

    return true;

}