fun main() {
    selecionarProduto()
}

fun selecionarProduto() {
    val carrinho = mutableSetOf<String>()

    println("Bem-vindo ao gerenciamento de carrinho de compras!")
    println("Você pode adicionar, remover e listar produtos no carrinho.")

    while (true) {
        println(
            "Opções:\n" +
                    "1. Adicionar produto ao carrinho\n" +
                    "2. Remover produto do carrinho\n" +
                    "3. Listar produtos no carrinho\n" +
                    "4. Sair do programa"
        )

        print("Escolha uma opção: ")
        val escolha = readlnOrNull()?.toIntOrNull()

        when (escolha) {
            1 -> adicionarProduto(carrinho)
            2 -> removerProduto(carrinho)
            3 -> listarProduto(carrinho)
            4 -> {
                println("Programa encerrado.")
                return
            }
            else -> {
                println("Nome invalido. Tente novamente.")
            }
        }
    }
}

fun adicionarProduto(carrinho: MutableSet<String>) {
    print("Digite o nome do produto a ser adicionado: ")
    val produto = lerProduto()
    carrinho.add(produto)
    println("'$produto' foi adicionado ao carrinho.")
}

fun removerProduto(carrinho: MutableSet<String>) {
    print("Digite o nome do produto a ser removido: ")
    val produto = lerProduto()
    if (produto.isNotEmpty() && carrinho.remove(produto)) {
        println("'$produto' foi removido do carrinho.")
    } else {
        println("'$produto' não foi encontrado no carrinho.")
    }
}

fun listarProduto(carrinho: MutableSet<String>) {
    if (carrinho.isEmpty()) {
        println("O carrinho está vázio!")
    } else {
        carrinho.forEachIndexed { indice, item ->
            println("${indice + 1}. $item")
        }

    }
}

fun lerProduto(): String {
    var entradaProduto = readlnOrNull()?.trim()
    while (entradaProduto.isNullOrEmpty()) {
        println("nome invalido! Tente novamente.")
        entradaProduto = readlnOrNull()?.trim()
    }
    return entradaProduto
}