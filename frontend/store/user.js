export const state = () => ({
  id: "",
  primeiroNome: "",
  sobrenome: "",
  estadoCivil: ""
})

export const mutation = {
  storeId: (state, data) => {
    state.id = data
  },
  storeName: (state, data) => {
    state.name = data
  },
  storeEmail: (state, data) => {
    state.email = data
  },
  storePassword: (state, data) => {
    state.password = data
  },
}
