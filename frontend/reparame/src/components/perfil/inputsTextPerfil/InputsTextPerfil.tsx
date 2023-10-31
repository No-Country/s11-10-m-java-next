import React from 'react'

const InputsTextPerfil = (data: any, setPostData: any, postData: any) => {
    return (
        <label className="flex flex-row bg-white gap-6 p-5 w-80 shadow-cardsPerfil rounded">
            {data.label}
            <input type="text" placeholder={data.data} className="w-full text-grayText outline-none"
                onChange={(e) => {
                    setPostData(
                        ...postData,
                        `${data.label}: ${e.target.value}`
                    )
                }} />
        </label>
    )
}

export default InputsTextPerfil