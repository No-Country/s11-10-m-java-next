import { useState } from "react"
import {AiOutlineStar, AiFillStar} from 'react-icons/ai'


export default function StartQuatify ({position, positionStart, setPositionStart}: {position:number, positionStart: number, setPositionStart : (arg: number) => void}) {

    const handleCountStart = () => {
        setPositionStart(position)
    }
    return (
        <>
        {
            position <= positionStart ? <AiFillStar onClick={handleCountStart}/> : <AiOutlineStar onClick={handleCountStart}  />
        }
        </>
    )
}