import { configureStore } from '@reduxjs/toolkit'
import serviciosReducer from "./features/serviciosSlice";
import logReducer from './features/pathSlice';
import categoryReducer from './features/categorySlice';

export const store = configureStore({
    reducer: {
        servicios: serviciosReducer,
        log: logReducer,
        category: categoryReducer,
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch