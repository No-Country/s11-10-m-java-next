
// import React from "react";
import HeaderManager from "../headerManager/HeaderManager"
import { Button, Input } from "@nextui-org/react";
// import axios from "axios";
import { FaLock, FaMap, FaMapMarker, FaPhoneAlt, FaRegEnvelope, FaUserAlt } from "react-icons/fa";
import { useForm } from "react-hook-form"


const Registro = () => {
    const {register, handleSubmit, watch, formState: { errors }, } = useForm()

    // const registro = axios.post('https://reparame-api.onrender.com/user/registro')
    //     .then(function (response) {console.log(response)} )
    // console.log(registro)

    const onSubmit = (data) => {
        console.log(data);
    }

    return (
        <section className='max-w-max-view w-full flex flex-col items-center '>
            <HeaderManager page='login' />
            <form className="w-full flex flex-col gap-4 " onSubmit={handleSubmit(onSubmit)}>
                <Input name="" startContent={ <FaUserAlt className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Nombre Completo" />
                <Input name="" startContent={ <FaUserAlt className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Apellido Completo" />
                <Input name="" startContent={<FaRegEnvelope className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="email" variant={"bordered"} placeholder="Email" />
                <Input name="" startContent={<FaLock className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="password" variant={"bordered"} placeholder="Contraseña" />
                <Input name="" startContent={<FaLock className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="DNI" />
                <Input name="" startContent={<FaMapMarker className="text-xl text-light-orange pointer-events-none flex-shrink-0"/> } radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Dirección" />
                <Input name="" startContent={<FaPhoneAlt className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Número telefónico" />
                <Input name="" startContent={<FaMap className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Provincia" />
                <Input name="" startContent={<FaMap className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Localidad" />
                <Input name="" startContent={<FaMapMarker className="text-xl text-light-orange pointer-events-none flex-shrink-0"/> } radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Zona" />
                <Input name="" startContent={ <FaUserAlt className="text-xl text-light-orange pointer-events-none flex-shrink-0"/>} radius="sm" size="lg" className="w-96 text-gray-1" type="date" variant={"bordered"} placeholder="Edad" />
            </form>
            <Button className='w-36 text-white hover:bg-orange bg-light-orange mt-8' radius="sm" type="submit" value={"enviar"}>Crear Cuenta</Button>
        </section>
    )
}

export default Registro