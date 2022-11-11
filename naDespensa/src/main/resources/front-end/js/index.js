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

// pegar ingredientes do BD ----------

let ingredientes = {
  data: [],
};

let theUrl = `http://localhost:6789/getIngredientejson`;

let respostaa = "";
fetch("http://localhost:6789/getIngredientejson")
  .then((response) => response.json())
  .then((data) => localStorage.setItem("respostaa", JSON.stringify(data)));

console.log(localStorage.respostaa);

stringona = localStorage.respostaa;
let elementos = JSON.parse(stringona);
for (let i = 0; i < elementos.length; i++) {
  ingredientes.data.push(elementos[i]);
}
console.log(ingredientes);

// ------------------------------------
/*
// pegar ingredientes do BD ----------
let ingredientes = {
  data: [],
};

let theUrl = `http://localhost:6789/getIngredientejson`;

let respostaa = "";
fetch("http://localhost:6789/getIngredientejson")
  .then((response) => response.json())
  .then((data) => (respostaa = JSON.stringify(data)));
console.log(respostaa);*/
/*
$.ajax({
  url: theUrl,
  method: "GET",
  contentType: "text/plain",
  preocessData: false,
  success: function (resposta) {
    //console.log(resposta);
  },
});*/
/*
//respostaa = JSON.stringify(respostaa);
console.log(respostaa);

//let stringona = respostaa;
var elementos = JSON.parse(respostaa);

for (let i = 0; i < elementos.length; i++) {
  ingredientes.data.push(elementos[i]);
}
console.log(ingredientes);
*/
// ------------------------------------

for (let i = 0; i < ingredientes.data.length; i++) {
  let b = document.createElement("button");
  let nomeee = ingredientes.data[i].nome.toUpperCase().split(" ");
  let nomeIngrediente = "";
  if (nomeee.length > 1) {
    nomeIngrediente += nomeee[0];
    nomeIngrediente += "_";
    nomeIngrediente += nomeee[1];
    nomeIngrediente += "_";
    nomeIngrediente += nomeee[2];
  } else {
    nomeIngrediente += nomeee[0];
  }
  console.log(nomeIngrediente);

  b.classList.add("b", nomeIngrediente, "naopesquisado", "button-value");
  //b.setAttribute("onclick", "filterProduct('"+i.nome+"')");
  b.setAttribute("onclick", "addFilter('" + ingredientes.data[i].nome + "')");
  b.textContent = ingredientes.data[i].nome;

  document.getElementById("ingredientesHidden").appendChild(b);
}

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

//Initially display all receitas
window.onload = () => {
  console.log(localStorage.pesquisaPorIngredientes);

  mostrarIngredientes();
  mostrarSelecionados();
};
