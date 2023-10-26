import React from 'react'
import { AiOutlineSearch } from 'react-icons/ai'
const SearchBar = () => {
  return (
    <form className='flex min-w-searchBar flex-row max-w-2xl w-full rounded-full'>
      <input type="text" name="" id="" placeholder='Búsqueda'
        className='w-full h-8 rounded-md pl-2 min-w-150p outline-none' />
      <button type="submit" className='relative right-6 cursor-pointer	pl-1' >
        <AiOutlineSearch />
      </button>
    </form>
  )
}

export default SearchBar