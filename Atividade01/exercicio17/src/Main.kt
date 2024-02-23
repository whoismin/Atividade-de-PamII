package fundamentos.controles
fun main(args: Array<String>){
    val alunos = arrayListOf("André", "Carla", "Marcos")
    for((indice, aluno) in alunos.withIndex()){
        println("$indice - $aluno \n")
    }
}