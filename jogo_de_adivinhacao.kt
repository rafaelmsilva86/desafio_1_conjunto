fun main() {

    val numeroAdivinhados = mutableSetOf<Int>()
    val numerosAleatorios = (1..10).random()
    val intervalos = 1..10
    var tentativas = 0

    while (true) {
        println("Adivinhe um número:")
        val palpite = readlnOrNull()?.toIntOrNull()
        if (palpite != null && palpite in intervalos) {
            when (palpite) {
                numerosAleatorios -> {
                    println("Você acertou!")
                    return
                }

                in numeroAdivinhados -> {
                    println("Você já digitou este número. Tente outro!")
                }

                else -> {
                    numeroAdivinhados.add(palpite)
                    tentativas++
                    val limiteTentativas = 3
                    println("Números de tentativas: $tentativas de $limiteTentativas")

                    val dica = if (tentativas == 3) "Maior" else "Menor"
                    println("Dica: o número é $dica que o seu palpite, $palpite")

                    if (tentativas == limiteTentativas){
                        println("Números de tentativas esgotadas. O número era $numerosAleatorios.\n" +
                                "Por favor, reinicie o jogo para jogar novamente.")
                    }



                }
            }
        }

    }


}
