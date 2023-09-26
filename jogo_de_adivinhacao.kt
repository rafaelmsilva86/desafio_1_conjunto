fun main() {
    escolherPalpites()
}

fun escolherPalpites() {
    val numeroAdivinhados = mutableSetOf<Int>()
    val numerosAleatorios = numeroAleatorios()
    val intervalos = 1..10
    var tentativas = 0
    println(
        "------------------------------------------\n" +
                "Vamos jogar ?\n" +
                "Descubra o número de 1 a 10 se for capaz!\n" +
                "------------------------------------------"
    )
    while (true) {

        println("Adivinhe um número:")
        val palpite = readlnOrNull()?.toIntOrNull()
        if (palpite != null && palpite in intervalos) {
            when (palpite) {
                numerosAleatorios -> {
                    println(
                        "P a r a b é n s!!!\n" +
                                " Você acertou!"
                    )
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

                    val dica = if (tentativas >= limiteTentativas) "Maior" else "Menor"
                    println("Dica: o número é $dica que o seu palpite, $palpite")

                    if (tentativas == limiteTentativas) {
                        println(
                            "Números de tentativas esgotadas.\n" +
                                    " O número era $numerosAleatorios.\n" +
                                    "Tente adivinhar novamente se for capaz!."
                        )
                    }
                }
            }
        }
    }
}

fun numeroAleatorios(): Int {
    return (1..10).random()
}