export const state = () => ({
  data: []
})

export const mutation = {
    storeData: (state, data) => {
      state.data = data
  },
}

