package funcoes
inline fun transacao(funcao: () -> Unit){
    println("abrindo transaçao...")
    try{
        funcao()
    }finally{
        println("fechando transaçao")
    }
}
fun main(args: Array<String>) {
    transacao {
    println("Executando SQL 1...")
    println("Executando SQL 2...")
    println("Executando SQL 3...")

}
}