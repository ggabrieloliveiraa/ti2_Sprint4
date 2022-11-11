let receitas = {
  data: [
    {
      productName: "Bolo de Chocolate",
      ingredientes: ["cHoCoLaTe", "farinha", "ovo", "acucar", "leite"],
      idReceita: "1",
      serve: "10",
      categoria: "sobremesa",
      image:
        "https://popularanime.com.br/wp-content/uploads/2022/10/power-chainsaw-man-1665409375204.jpg",
    },
    {
      productName: "Bolo de Chocolate sem Acucar",
      ingredientes: ["cHoCoLaTe", "farinha", "ovo", "leite"],
      idReceita: "4",
      serve: "10",
      categoria: "sobremesa",
      image:
        "https://popularanime.com.br/wp-content/uploads/2022/10/power-chainsaw-man-1665409375204.jpg",
    },
    {
      productName: "Bolo de Cenoura",
      ingredientes: [
        "cHoCoLaTe",
        "cenoura",
        "farinha",
        "ovo",
        "acucar",
        "leite",
      ],
      idReceita: "2",
      serve: "10",
      categoria: "sobremesa",
      image:
        "https://popularanime.com.br/wp-content/uploads/2022/10/power-chainsaw-man-1665409375204.jpg",
    },
    {
      productName: "Bolo de Morango",
      ingredientes: ["morango", "farinha", "ovo", "acucar", "leite"],
      idReceita: "3",
      serve: "10",
      categoria: "sobremesa",
      image:
        "https://popularanime.com.br/wp-content/uploads/2022/10/power-chainsaw-man-1665409375204.jpg",
    },
    {
      productName: "Macarrao a Bolonhesa",
      ingredientes: ["Massadetomate", "sal"],
      idReceita: "5",
      serve: "10",
      categoria: "prato salgado",
      image:
        "https://popularanime.com.br/wp-content/uploads/2022/10/power-chainsaw-man-1665409375204.jpg",
    },
    {
      productName: "Macarrao na Chapa",
      ingredientes: ["Cebola", "sal", "shoyo"],
      idReceita: "6",
      serve: "10",
      categoria: "prato salgado",
      image:
        "https://popularanime.com.br/wp-content/uploads/2022/10/power-chainsaw-man-1665409375204.jpg",
    },
    {
      productName: "Vitamina",
      ingredientes: ["Abacate", "leite"],
      idReceita: "7",
      serve: "10",
      categoria: "bebida",
      image:
        "https://popularanime.com.br/wp-content/uploads/2022/10/power-chainsaw-man-1665409375204.jpg",
    },
  ],
};

let ingredientes = {
  data: [
    {
      nome: "Chocolate",
      idIngrediente: "1",
    },
    {
      nome: "Acucar",
      idIngrediente: "2",
    },
    {
      nome: "Cenoura",
      idIngrediente: "3",
    },
    {
      nome: "Morango",
      idIngrediente: "4",
    },
    {
      nome: "Abacate",
      idIngrediente: "5",
    },
    {
      nome: "Cebola",
      idIngrediente: "6",
    },
    {
      nome: "Massadetomate",
      idIngrediente: "7",
    },
  ],
};

function depois() {
  for (let i of ingredientes.data) {
    let b = document.createElement("button");
    let nomeIngrediente = i.nome.toUpperCase();
    b.classList.add("b", nomeIngrediente, "naopesquisado", "button-value");
    //b.setAttribute("onclick", "filterProduct('"+i.nome+"')");
    b.setAttribute("onclick", "addFilter('" + i.nome + "')");
    b.textContent = i.nome;

    document.getElementById("ingredientesHidden").appendChild(b);
  }
}

/*
var ii = JSON.parse(localStorage.getItem("ingredientesLocal"));

ii = ingredientes;

for (let i = 0; i < ii.data.length; i++) {
  let b = document.createElement("button");
  let nomeIngrediente = ii.data[i].nome.toUpperCase();
  console.log(nomeIngrediente);
  b.classList.add("b", nomeIngrediente, "naopesquisado", "button-value");
  //b.setAttribute("onclick", "filterProduct('"+i.nome+"')");
  b.setAttribute("onclick", "addFilter('" + ii.data[i].nome + "')");
  b.textContent = ii.data[i].nome;

  document.getElementById("ingredientesHidden").appendChild(b);
}*/

// mostrar ingredientes
function mostrarIngredientes() {
  //select all bs
  let elements = document.querySelectorAll(".b");
  //loop through all bs
  elements.forEach((element) => {
    if (
      element.classList.contains("pesquisado") &&
      !element.classList.contains("active")
    ) {
      document.getElementById("ingredientes").appendChild(element);
      console.log("+pesquisado");
    }
  });
  elements.forEach((element) => {
    if (
      element.classList.contains("pesquisado") &&
      element.classList.contains("active")
    ) {
      document.getElementById("ingredientes").appendChild(element);
      console.log("+pesquisado");
    }
  });
  elements.forEach((element) => {
    if (element.classList.contains("naopesquisado")) {
      document.getElementById("ingredientes").appendChild(element);
      console.log("+NAOpesquisado");
    }
  });
}

function mostrarSelecionados() {
  //select all bs
  let elements = document.querySelectorAll(".b");
  //loop through all bs
  let div = document.getElementById("ingredientesSelecionados");
  while (div.firstChild) {
    div.removeChild(div.firstChild);
  }
  elements.forEach((element) => {
    if (element.classList.contains("active")) {
      document.getElementById("ingredientesSelecionados").appendChild(element);
      console.log("+pesquisado");
    }
  });
}

let selectedButtons = [];
//parameter passed from button (Parameter same as ingredientes)
function addFilter(value) {
  //Button class code
  let buttons = document.querySelectorAll(".button-value");
  buttons.forEach((button) => {
    //check if value equals innerText
    if (value.toUpperCase() == button.innerText.toUpperCase()) {
      button.classList.add("active");
      button.removeAttribute("onclick");
      button.setAttribute("onclick", "remove('" + value + "')");
    } else {
      //button.classList.remove("active");
    }
  });
  selectedButtons.push(value);

  console.log(selectedButtons);
  localStorage.setItem(
    "pesquisaPorIngredientes",
    JSON.stringify(selectedButtons)
  );
  console.log(localStorage.pesquisaPorIngredientes);
  mostrarIngredientes();
  mostrarSelecionados();
}

function remove(value) {
  let buttons = document.querySelectorAll(".button-value");
  buttons.forEach((button) => {
    //check if value equals innerText
    if (value.toUpperCase() == button.innerText.toUpperCase()) {
      button.removeAttribute("onclick");
      button.setAttribute("onclick", "addFilter('" + value + "')");
      button.classList.remove("active");
    }
  });
  selectedButtons = selectedButtons.filter((e) => e !== value);
  console.log("botoes:" + selectedButtons);
  //select all cards

  let pesquisaAtual = JSON.parse(localStorage.pesquisaPorIngredientes);
  pesquisaAtual = pesquisaAtual.filter((e) => e !== value);
  localStorage.setItem(
    "pesquisaPorIngredientes",
    JSON.stringify(pesquisaAtual)
  );
  console.log(localStorage.pesquisaPorIngredientes);
  mostrarIngredientes();
  mostrarSelecionados();
}

//PESQUISAR RECEITA
function guardarTermoInput() {
  console.log("mudança");
  let searchInput = document.getElementById("search-input1").value;

  console.log(searchInput);
}

//PESQUISAR INGREDIENTE input oninput
function pesquisarIngrediente() {
  console.log("mudança");
  let searchInput = document.getElementById("search-input2").value;
  let elements = document.querySelectorAll(".b");
  let bs = document.querySelectorAll(".b");

  //loop through all elements
  if (searchInput.length > 0) {
    elements.forEach((element, i) => {
      //check if text includes the search value
      if (
        elements[i].innerText.toUpperCase().includes(searchInput.toUpperCase())
      ) {
        //display matching card
        bs[i].classList.remove("naopesquisado");
        bs[i].classList.add("pesquisado");
        console.log(bs[i]);
      } else {
        if (bs[i].classList.contains("pesquisado")) {
          bs[i].classList.remove("pesquisado");
          bs[i].classList.add("naopesquisado");
        }
        //console.log(bs[i]);
      }
    });
  } else {
    elements.forEach((element, i) => {
      bs[i].classList.remove("pesquisado");
      bs[i].classList.add("naopesquisado");
    });
  }

  //document.getElementById("ingredientes").innerHTML = "";

  mostrarIngredientes();
  mostrarSelecionados();
}

//get("/getIngredienteApp/:k", (request, response) -> ingredienteService.getIngredienteApp(request.params(":k")));
var funcShowIngredients = function () {
  for (let k = 1; k <= 30; k++) {
    let theUrl = `http://localhost:6789/getIngredienteApp/${k}`;
    $.ajax({
      url: theUrl,
      method: "GET",
      contentType: "text/plain",
      preocessData: false,
      success: function (resposta) {
        //console.log(resposta);
        createIngredients(resposta);
      },
    });
  }
};

var createIngredients = function (resposta) {
  const ingInfo = resposta.split(",");

  const nome = ingInfo[1].split(" ");
  var nomeF = "";
  if (nome.length >= 2) {
    nomeF += nome[0];
    nomeF += " ";
    nomeF += nome[1];
    if (nome[1] == "de" || nome[1] == "da" || nome[1] == "do") {
      nomeF += " ";
      nomeF += nome[2];
    }
  } else {
    nomeF += ingInfo[1];
  }

  var nomeDiv = "";
  if (nome.length >= 2) {
    nomeDiv += nome[0];
    nomeDiv += "_";
    nomeDiv += nome[1];
    if (nome[1] == "de" || nome[1] == "da" || nome[1] == "do") {
      nomeDiv += "_";
      nomeDiv += nome[2];
    }
  } else {
    nomeDiv += ingInfo[1];
  }

  let novoIngrediente = {
    nome: nomeF,
    idIngrediente: ingInfo[0],
  };

  ingredientes.data.push(novoIngrediente);
  console.log(ingredientes);

  // Insere o novo objeto no array
  //ii.data.push(novoIngrediente);

  // Atualiza os dados no Local Storage
  //localStorage.setItem("ingredientesLocal", JSON.stringify(ii));

  //ingredientes.data.push(novoIngrediente);
};

//Initially display all receitas
window.onload = () => {
  funcShowIngredients();
  depois();
  console.log(localStorage.pesquisaPorIngredientes);

  mostrarIngredientes();
  mostrarSelecionados();
};
