fun prestado(item: Any, usuario: Usuario): String {
    return when (usuario) {
        is Usuario.Estudiante -> when (item) {
            is Libro -> "El estudiante ${usuario.nombre} ha tomado prestado el libro: ${item.titulo} por 2 semanas."
            is Revista -> "El estudiante ${usuario.nombre} ha tomado prestada la revista: ${item.titulo} por 1 semana."
            is DVD -> "El estudiante ${usuario.nombre} ha tomado prestado el DVD: ${item.titulo} por 1 semana."
            else -> "El item no es válido."
        }
        is Usuario.Profesor -> when (item) {
            is Libro -> "El profesor ${usuario.nombre} ha tomado prestado el libro: ${item.titulo} por un período de 1 mes."
            is Revista -> "El profesor ${usuario.nombre} ha tomado prestada la revista: ${item.titulo} por un período de 2 semanas."
            is DVD -> "El profesor ${usuario.nombre} ha tomado prestado el DVD: ${item.titulo} por un período de 3 semanas."
            else -> "El item no es válido."
        }
        is Usuario.Visitante -> "El visitante ${usuario.nombre} no puede tomar prestado  nada."

    }
}


fun main() {

    val libro1 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967)
    val revista1 = Revista("National Geographic", 124, 2021)
    val dvd1 = DVD("The Matrix", "Hermanos Wachowski", 1999)

    val estudiante = Usuario.Estudiante("E001", "Luque", "Botánica")
    val profesor = Usuario.Profesor("P001", "Don Diego", "Programación")
    val visitante = Usuario.Visitante("V001", "Antonio")

    println(prestado(libro1, estudiante))
    println(prestado(revista1, profesor))
    println(prestado(dvd1, visitante))


}