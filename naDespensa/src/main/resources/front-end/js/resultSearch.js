// pegar ingredientes do BD ----------

let receitas = {
  data: [],
};

let respostaa2 = "";
fetch("http://localhost:6789/listreceitas")
  .then((respons) => respons.json())
  .then((dataa) => localStorage.setItem("respostaa2", dataa));

localStorage.setItem(stringassa, respostaa2);

localStorage.setItem("valor", stringassa);
localStorage.valor = localStorage.valor.replace(
  "%22,%22preparo%22:%221.",
  "",
  "preparo:",
  ""
);
console.log(localStorage.valor);

stringona2 = localStorage.valor;
let elementos2 = JSON.parse(stringona2);
for (let i = 0; i < elementos2.length; i++) {
  receitas.data.push(elementos2[i]);
}

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

/*
card <a href="recipe.html">
c1      <div class="cardRecipe ">
c2        <div class="card mb-3 mx-auto" style="max-width: 675px">
c3          <div class="row g-0 cardBorderBottom">
c4            <div class="col-md-4">
c5              <img src="assets/recipes/tropeiro.png" class="img-fluid rounded-start" alt="...">
              </div>
c6            <div class="col-md-8">
c7              <div class="card-body">
c8                <h3 class="card-title">Feijão Tropeiro</h3>
c9                <hr style="height:2px;border-width:0;color:black;background-color:black">                   
c10 c11           <p class="card-text"><span class="recipeDesc">Dificuldade: </span>médio</p>
c12 c13           <p class="card-text"><span class="recipeDesc">Tempo de preparo: </span>1h</p>
c14 c15           <p class="card-text"><span class="recipeDesc">Serve: </span>4 pessoas</p>
                </div>
              </div>
            </div>
          </div>
        </div>
    </a>
*/

for (let i of receitas.data) {
  //Create Card
  let card = document.createElement("a");
  //Card should have ingredientes and should stay hidden initially
  card.classList.add("card", "hide2");
  for (let j = 0; j < i.ingredientes.length; j++) {
    card.classList.add(i.ingredientes[j].toUpperCase());
    //console.log(i.ingredientes[j]);
  }
  card.setAttribute("href", "recipe.html");

  let container1 = document.createElement("div");
  container1.classList.add("cardRecipe");

  let container2 = document.createElement("div");
  container2.classList.add("card3", "mb-3", "mx-auto");
  container2.setAttribute("style", "max-width: 675px");

  let container3 = document.createElement("div");
  container3.classList.add("row", "g-0", "cardBorderBottom");

  let container4 = document.createElement("div");
  container4.classList.add("col-md-4");

  let container5 = document.createElement("img");
  container5.classList.add("img-fluid", "rounded-start");
  container5.setAttribute("src", i.image);

  let container6 = document.createElement("div");
  container6.classList.add("col-md-8");

  let container7 = document.createElement("div");
  container7.classList.add("card-body");

  let container8 = document.createElement("h3");
  container8.classList.add("card-title");
  container8.innerText = i.productName.toUpperCase();

  let container9 = document.createElement("hr");
  container9.setAttribute(
    "style",
    "height:2px;border-width:0;color:black;background-color:black"
  );

  let container10 = document.createElement("p");
  container10.classList.add("card-text");

  let container11 = document.createElement("span");
  container11.classList.add("recipeDesc");
  container11.innerText = "Dificuldade: " + i.dificuldade;

  let container12 = document.createElement("p");
  container12.classList.add("card-text");

  let container13 = document.createElement("span");
  container13.classList.add("recipeDesc");
  container13.innerText = "Tempo de preparo: " + i.tempo + " minutos";

  let container14 = document.createElement("p");
  container14.classList.add("card-text");

  let container15 = document.createElement("span");
  container15.classList.add("recipeDesc");
  container15.innerText = "Serve: " + i.serve + " pessoas";

  container10.appendChild(container11);
  container12.appendChild(container13);
  container14.appendChild(container15);

  container7.appendChild(container8);
  container7.appendChild(container9);
  container7.appendChild(container10);
  container7.appendChild(container12);
  container7.appendChild(container14);

  container4.appendChild(container5);

  container6.appendChild(container7);
  container3.appendChild(container4);
  container3.appendChild(container6);

  container2.appendChild(container3);
  container1.appendChild(container2);

  card.appendChild(container1);
  //card.appendChild(container5);

  document.getElementById("receitas").appendChild(card);
}

function mostrarReceitas() {
  //select all cards
  let elements = document.querySelectorAll(".card");

  let pesquisaAtual = JSON.parse(localStorage.pesquisaPorIngredientes);

  //loop through all cards
  if (pesquisaAtual.length == 0) {
    elements.forEach((element) => {
      element.classList.remove("hide2");
    });
  } else {
    elements.forEach((element) => {
      element.classList.add("hide2");
    });
    elements.forEach((element) => {
      for (let i = 0; i < pesquisaAtual.length; i++) {
        value = pesquisaAtual[i].toUpperCase();
        //Check if element contains ingredientes class
        if (element.classList.contains(value)) {
          //display element based on ingredientes
          element.classList.remove("hide2");
        } else {
          //hide2 other elements
          //element.classList.add("hide2");
        }
      }
    });
  }
}

// mostrar ingredientes
function mostrarIngredientes() {
  let pesquisaAtual = JSON.parse(localStorage.pesquisaPorIngredientes);

  for (let i = 0; i < pesquisaAtual.length; i++) {
    let b = document.createElement("button");
    let nomeIngrediente = pesquisaAtual[i].toUpperCase();
    b.classList.add("b", nomeIngrediente, "active", "button-value");
    b.setAttribute("onclick", "addFilter('" + i.nome + "')");
    b.textContent = pesquisaAtual[i];
    //document.getElementById("Button").disabled = true;

    document.getElementById("ingredientes").appendChild(b);
  }
}

//Initially display all receitas
window.onload = () => {
  mostrarIngredientes();
  mostrarReceitas();
};
