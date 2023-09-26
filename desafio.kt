enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val nivel: Nivel) {
    val formacoesConcluidas = mutableListOf<Formacao>()
}


data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
    inscritos.add(usuario)
	}
}

fun main() {
    // Criação de usuários
    val usuario1 = Usuario("João", Nivel.BASICO)
    val usuario2 = Usuario("Maria", Nivel.INTERMEDIARIO)

    // conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 120)

    // formação e matricular de usuários 
    val formacao1 = Formacao("Desenvolvimento Web", listOf(conteudo1, conteudo2))
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    // informações sobre a formação e seus inscritos
    println("Formação: ${formacao1.nome}")
    println("Conteúdos: ${formacao1.conteudos.map { it.nome }}")
    println("Inscritos: ${formacao1.inscritos.map { it.nome }}")
}
