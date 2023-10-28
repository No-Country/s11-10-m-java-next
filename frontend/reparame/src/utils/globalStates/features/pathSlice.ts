import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    value: ''
}

export const logSlice = createSlice({
    name: 'log',
    initialState,
    reducers: {
        setLog: (state, action) => {
            state.value = null ? localStorage.getItem('log') :
                state.value = action.payload
        }
    }
})

export const { setLog } = logSlice.actions;
export default logSlice.reducer; 