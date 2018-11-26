object jackSparrow extends Pirata {
  var _poderDePelea : Double = 0
  var _inteligencia : Double = 0
  var _ingredientes = List("")

  override def poderDeMando(): Double = {
    _poderDePelea * _inteligencia * _energiaInicial
  }

  override def seHirio(unValor: Double): Unit = {
    _poderDePelea *= unValor
    _inteligencia *= unValor
  }

  def tomarRonCon(unPirata : Pirata): Unit = {
    this.aumentarEnergia(100)
    unPirata.tomarRonConJackSparrow()
  }

  def aumentarEnergia(unValor : Int): Unit = {
    _energiaInicial += unValor
  }

  def recibirIngrediente(unIngrediente : String): Unit = {
    _ingredientes = unIngrediente :: _ingredientes
  }

  //Setter
  def poderDePelea_(unValor: Double): Unit = {
    _poderDePelea = unValor
  }

  //Getter
  def poderDePelea: Double = _poderDePelea

  //Setter
  def inteligencia_(unValor: Double): Unit = {
    _inteligencia = unValor
  }

  //Getter
  def inteligencia: Double = _inteligencia

  //Setter
  def ingredientes_(unaLista: List[String]): Unit = {
    _ingredientes = unaLista
  }

  //Getter
  def ingredientes: List[String] = _ingredientes

}
