// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuario ${usuario.nome} matriculado na formação $nome")
    }

    fun mostrarInscritos(){
        println("Inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome}")}
    }
}

fun main() {

    //Conteudos
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 30)
    val kotlinIntermediario = ConteudoEducacional("Kotlin Intermediário", 60)
    val webAvancado= ConteudoEducacional("Web Avançado", 120)

    //Formações

    val formaçãoKotlin = Formacao(
        nome = "Formação Kotlin",
        conteudos = listOf(kotlinBasico, kotlinIntermediario),
        nivel = Nivel.INTERMEDIARIO
    )

    val formaçãoWeb = Formacao(
        nome = "Formação Web Avançado",
        conteudos = listOf(webAvancado),
        nivel = Nivel.DIFICIL
    )

    val aluno1 = Usuario("Rodolfo")
    val aluno2 = Usuario("Ana")

    formaçãoKotlin.matricular(aluno1)
    formaçãoKotlin.matricular(aluno2)
    formaçãoWeb.matricular(aluno2)

    formaçãoKotlin.mostrarInscritos()
    formaçãoWeb.mostrarInscritos()
}
