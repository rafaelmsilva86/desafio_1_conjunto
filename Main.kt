fun main() {
    val numerosUnicos = adicionarNumeros()
    calcularSoma(numerosUnicos)
    encontrarMaiorNumero(numerosUnicos)
    encontrarMenorNumero(numerosUnicos)
}

fun encontrarMenorNumero(numeros: Set<Int>) {
    val menor = numeros.minOrNull()
    println("O menor número no conjunto é: $menor")
}

fun encontrarMaiorNumero(numeros: Set<Int>) {
    val maior = numeros.maxOrNull()
    println("O maior número no conjunto é: $maior")
}

fun calcularSoma(numeros: Set<Int>) {
    val soma = numeros.sum()
    println("A soma de todos os números no conjunto é: $soma")
}

fun adicionarNumeros(): Set<Int> {
    val numerosUnicos = mutableSetOf<Int>()

    println("Bem-vindo ao programa de conjuntos de números únicos!")
    println("Você pode adicionar números inteiros únicos ao conjunto.")
    println("Digite números inteiros únicos:")

    var numeroAdicionado = lerNumero()
    while (numeroAdicionado > 0) {
        numerosUnicos.add(numeroAdicionado)
        numeroAdicionado = lerNumero()
    }

    println("Lista: ${numerosUnicos.joinToString(", ")}")

    return numerosUnicos
}

fun lerNumero(): Int {
    var entrada = readLine()?.toIntOrNull()
    while (entrada == null) {
        println("Número invalido! tente novamente")
        entrada = readLine()?.toIntOrNull()
    }
    return entrada
}
