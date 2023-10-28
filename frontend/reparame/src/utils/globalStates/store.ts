import { configureStore } from '@reduxjs/toolkit'
import serviciosReducer from "./features/serviciosSlice";
import logReducer from './features/pathSlice';

export const store = configureStore({
    reducer: {
        servicios: serviciosReducer,
        log: logReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch