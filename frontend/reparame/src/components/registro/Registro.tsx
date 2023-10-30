'use client'
import React from "react";
import HeaderManager from "../headerManager/HeaderManager"
import { Button, Input } from "@nextui-org/react";
import { useForm } from "react-hook-form"
import { Select, SelectItem } from "@nextui-org/react";

import { FaLock, FaMap, FaMapMarker, FaPhoneAlt, FaRegEnvelope, FaUserAlt } from "react-icons/fa";
import { postUser } from "@/utils/requestUser/postUser";
const roles = [{ label: "Prestador", value: "Prestador" }, { label: "Cliente", value: "Cliente" }]

const Registro = () => {
    const { register, handleSubmit } = useForm()

    const onSubmit = (data) => {
        postUser(data)
            .then(res => console.log(res))
            .catch(error => console.log(error))
        console.log(data)
    }
    return (
        <section className='max-w-max-view w-full flex flex-col items-center '>
            <HeaderManager page='login' />
            <form onSubmit={handleSubmit(onSubmit)} className="w-full flex flex-col gap-4 ">
                <Input  {...register("nombreCompleto")} name="nombreCompleto" startContent={<FaUserAlt className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Nombres" />
                <Input {...register("apellidoCompleto")} name="apellidoCompleto" startContent={<FaUserAlt className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Apellidos" />
                <Input {...register("username")} name="username" startContent={<FaRegEnvelope className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="email" variant={"bordered"} placeholder="Email" />
                <Input {...register("password")} name="password" startContent={<FaLock className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="password" variant={"bordered"} placeholder="Contraseña" />
                <Input {...register("direccion")} name="direccion" startContent={<FaMapMarker className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Dirección" />
                <Input {...register("numeroTelefonico")} name="numeroTelefonico" startContent={<FaPhoneAlt className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Número telefónico" />
                <Input {...register("provincia")} name="provincia" startContent={<FaMap className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Provincia" />
                <Input {...register("localidad")} name="localidad" startContent={<FaMap className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Localidad" />
                <Input {...register("fechaNacimiento")} name="fechaNacimiento" startContent={<FaUserAlt className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="date" variant={"bordered"} />
                <Input {...register("zona")} name="zona" startContent={<FaMapMarker className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="Zona" />
                <Input {...register("dni")} name="dni" startContent={<FaLock className="text-xl text-light-orange pointer-events-none flex-shrink-0" />} radius="sm" size="lg" className="w-96 text-gray-1" type="text" variant={"bordered"} placeholder="DNI" />
                <Select
                    {...register("rol")}
                    // label="Roles"
                    placeholder="Selecciona un Rol"
                    className="text-xl text-light-orange flex-shrink-0"
                >
                    {roles.map((rol) => (
                        <SelectItem key={rol.value} value={rol.value}>
                            {rol.label}
                        </SelectItem>
                    ))}
                </Select>
                <Button className='w-36 text-white hover:bg-orange bg-light-orange mt-8' radius="sm" type="submit" value={"enviar"}>Crear Cuenta</Button>
            </form>
        </section>
    )
}

export default Registro