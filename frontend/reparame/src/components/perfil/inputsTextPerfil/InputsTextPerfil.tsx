import React from "react";
import Image from "next/image";

type InputType =
    | "email"
    | "password"
    | "number"
    | 'text'



interface InputContainerProps {
    label?: string;
    type: InputType;
    placeholder: string;
    onClick?: (e: React.MouseEvent) => void;
    onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
    required?: boolean;
    disabled?: boolean;
    defaultValue?: number | string;
}

const InputsTextPerfil: React.FC<InputContainerProps> = ({
    label,
    type,
    placeholder,
    onClick,
    onChange,
    required,
    defaultValue,
}) => {
    return (
        <label className="flex flex-row bg-white gap-6 p-5 w-80 shadow-cardsPerfil rounded">
            {label}
            <input
                type={type}
                placeholder={placeholder}
                onChange={onChange}
                onClick={onClick}
                defaultValue={defaultValue}
                required={required}
                className="w-full text-grayText outline-none"
            />
        </label>

    );
};

export default InputsTextPerfil;
