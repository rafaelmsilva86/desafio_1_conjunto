fun main() {
    selecionarLivros()
}

fun selecionarLivros() {

    println("Bem-vindo à biblioteca virtual!")
    println("Você pode adicionar, remover, listar e pesquisar livros na biblioteca.")

    val biblioteca = mutableSetOf<String>()
    while (true) {
        println(
            "Opções:\n" +
                    "1. Adicionar livro à biblioteca\n" +
                    "2. Remover livro da biblioteca\n" +
                    "3. Listar todos os livros na biblioteca\n" +
                    "4. Pesquisar livro na biblioteca\n" +
                    "5. Sair do programa"
        )
        println("Escolha uma opção:")
        val opcao = readlnOrNull()?.toIntOrNull()
        when (opcao) {
            1 -> adicionarLivros(biblioteca)
            2 -> removerLivros(biblioteca)
            3 -> listarLivros(biblioteca)
            4 -> pesquisarLivros(biblioteca)
            5 -> {
                println("Programa encerrado!")
                return
            }

            else -> {
                println("Opção inválida. Tente novamente.")
            }

        }
    }
}

fun adicionarLivros(biblioteca: MutableSet<String>) {
    print("Digite o título do livro a ser adicionado: ")
    val livro = lerLivros()
    if (livro.isNotEmpty()) {
        biblioteca.add(livro)
        println("$livro adicionado a biblioteca")
    } else {
        println("Título do livro inválido!")
    }
}

fun removerLivros(biblioteca: MutableSet<String>) {
    print("Digite o título do livro a ser removido: ")
    val remova = lerLivros()
    if (remova.isNotEmpty() && biblioteca.remove(remova)) {
        println("Removido o livro: $remova")
    } else {
        println("Não consta este título na biblioteca.")
    }

}

fun listarLivros(biblioteca: MutableSet<String>) {
    if (biblioteca.isEmpty()) {
        println("A biblioteca está vázia.")
    } else {
        biblioteca.forEachIndexed { index, livro ->
            println("${index + 1}. $livro")
        }
    }

}

fun pesquisarLivros(biblioteca: MutableSet<String>) {
    println("Digite o título do livro a ser pesquisado: ")
    val pesiquese = lerLivros()
    if (pesiquese.isNotEmpty() && pesiquese in biblioteca) {
        println("$pesiquese está disponível na biblioteca.")
    }else{
        println("$pesiquese não foi encontrado na biblioteca!")
    }
}

fun lerLivros(): String {
    var entradaLivros = readlnOrNull()?.trim()
    while (entradaLivros.isNullOrEmpty()) {
        println("Título inválido! Tente novamente.")
        entradaLivros = readlnOrNull()?.trim()
    }
    return entradaLivros
}
