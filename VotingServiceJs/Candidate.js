class Candidate{
  #name
  #position
    #id

  constructor(name,position, id){
      this.#name = name;
      this.#position = position;
      this.#id = id;
  }

  get name(){
      return this.#name;
  }
  get position(){
      return this.#position;
  }
  get id(){
      return this.#id;
  }



}

module.exports = Candidate;