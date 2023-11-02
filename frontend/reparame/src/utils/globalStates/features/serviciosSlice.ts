import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    value: ''
}

export const serviciosSlice = createSlice({
    name: 'servicioId',
    initialState,
    reducers: {
        verServicios: (state, action) => {
            state.value = action.payload
        }
    }
})

export const { verServicios } = serviciosSlice.actions;
export default serviciosSlice.reducer; 