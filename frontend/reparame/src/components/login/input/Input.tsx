import Image from "next/image";
import React from "react";

type InputType = "email" | "password" | "text";

interface InputContainerProps {
  type: InputType;
  placeholder: string;
  valueContainerName: string;
  style?: React.CSSProperties;
  onClick?: (e: React.MouseEvent) => void;
  onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
  required?: boolean;
  disabled?: boolean;
  defaultValue?: number | string;
  iconOrReactElement: string;
  className?: string;
}

const Input: React.FC<InputContainerProps> = ({
  type,
  placeholder,
  style,
  onClick,
  onChange,
  required,
  defaultValue,
  iconOrReactElement,
  className,
}) => {
  return (
    <div className={className}>
      {type === "email" || type === "text" || type === "password" ? (
        <div className="flex gap-2 items-center w-full">
          <Image
            className="w-8 h-8"
            src={`/${iconOrReactElement}`}
            alt="icon"
            width={30}
            height={30}
          />
          <input
            type={type}
            placeholder={placeholder}
            style={style}
            onChange={onChange}
            onClick={onClick}
            defaultValue={defaultValue}
            required={required}
            className="w-full outline-none"
          />
        </div>
      ) : null}
    </div>
  );
};

export default Input;
