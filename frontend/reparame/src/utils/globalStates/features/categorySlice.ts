import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    value: ''
}

export const pathSlice = createSlice({
    name: 'category',
    initialState,
    reducers: {
        setCategory: (state, action) => {
            state.value = null ? localStorage.getItem('category') :
                state.value = action.payload
        }
    }
})

export const { setCategory } = pathSlice.actions;
export default pathSlice.reducer; 