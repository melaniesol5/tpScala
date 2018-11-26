object holandesErrante extends Bando {

  override def bonus(unBarco: Barco): Unit = {
    unBarco.duplicarTripulacion()
  }
}