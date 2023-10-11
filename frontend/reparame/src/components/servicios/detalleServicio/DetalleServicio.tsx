import { useAppDispatch } from '@/utils/globalStates/hooks'
import { verPrestador } from '@/utils/globalStates/features/prestadoresSlice'

const DetalleServicio = (prestador: any, setId: Function) => {
    const dispatch = useAppDispatch()
    return (
        <div>
            <button onClick={() => { dispatch(verPrestador('')) }}>{`<- volver`}</button>
            <h1>Aca van los Datos detallados</h1>
            <p>{prestador.prestador.name}</p>
            <p>{prestador.prestador.username}</p>
            <p>{prestador.prestador.email}</p>
            <p>{prestador.prestador.phone}</p>
        </div>
    )
}

export default DetalleServicio