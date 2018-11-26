class Barco(var resistencia: Int, var poderDeFuego: Int, var municiones: Double, var tripulacion: List[Pirata], var capitan: Pirata, var bando: Bando) {

  def elegirCapitan(): Unit = {
    capitan = tripulacion.maxBy(unPirata => unPirata.poderDeMando())
  }

  def atacarA(otroBarco : Barco): Unit = {
    if( this.fuerzaDelBarco() > otroBarco.fuerzaDelBarco() ) {
      otroBarco.herirTripulacion()
      this.sumarTripulacion(otroBarco)
      this.vaciarBarcoEnemigo(otroBarco)
    }
    else {
      this.herirTripulacion()
      otroBarco.sumarTripulacion(this)
      otroBarco.vaciarBarcoEnemigo(this)
    }
  }

  def fuerzaDelBarco(): Double = {
    tripulacion.map(unPirata => unPirata.poderDeMando()).sum
  }

  def herirTripulacion(): Unit = {
    tripulacion.foreach(unPirata => unPirata.seHirio(0.5))
  }

  def sumarTripulacion(otroBarco : Barco): Unit = {
    tripulacion = tripulacion ::: otroBarco.tripulacion.filter(unPirata => unPirata.poderDeMando() > 100)
  }

  def vaciarBarcoEnemigo(otroBarco: Barco): Unit = {
    otroBarco.resistencia = 0
    otroBarco.municiones = 0
    otroBarco.poderDeFuego = 0
    otroBarco.capitan = null
    otroBarco.tripulacion = List()
  }

  def dispararCanionazos(cantidadDeCanionazos : Int , otroBarco : Barco): Unit = {
    if(this.tieneSuficienteMuniciones(cantidadDeCanionazos)) {
      otroBarco.disminuirResistencia(50 * cantidadDeCanionazos)
      otroBarco.eliminarTripulacion()
      this.disminuirMuniciones(cantidadDeCanionazos)
    }
    else {
      throw new IllegalArgumentException("El barco no posee suficientes municiones...")
    }
  }

  def tieneSuficienteMuniciones(cantidadDeCanionazos : Int): Boolean = {
    municiones - cantidadDeCanionazos >= 0
  }

  def disminuirResistencia(unValor : Int): Unit = {
    resistencia -= unValor
    if(resistencia < 0)
      resistencia = 0
  }

  def disminuirMuniciones(unValor : Int): Unit = {
    municiones -= unValor
  }

  def eliminarTripulacion(): Unit = {
    tripulacion = tripulacion.filter(unPirata => unPirata._energiaInicial > 20)
  }

  def aumentarPoderDeFuego(unValor : Int): Unit = {
    poderDeFuego += unValor
  }

  def aumentarMuniciones(unValor : Double): Unit = {
    municiones += unValor
  }

  def duplicarTripulacion(): Unit = {
    tripulacion = tripulacion ::: tripulacion
  }

  def aplicarBonus(): Unit = {
    bando.bonus(this)
  }
}
