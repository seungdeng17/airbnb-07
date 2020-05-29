import React from 'react'
import styled from 'styled-components';

const LocationFilterWrap = styled.div`
    position: relative;
    color: #484848;
    cursor: pointer;
`;

const HighlightBorder = styled.div`
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border: 2.25px solid #000;
    border-radius: 15px;
    pointer-events: none;
    box-sizing: border-box;
`;

const LocationFilterBtn = styled.div`
    position: relative;
    border: 1.19px solid #7f8c8d99;
    box-shadow: ${(props) => props.theme.boxShadow};
    border-radius: 15px;
    padding: 0 10px;
    width: 100%;
    height: 100%;
    line-height: 39.6px;
    box-sizing: border-box;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    select {
        color: #484848;
        font-size: 14px;
        font-weight: 600;
        font-family: 'Noto Sans KR', sans-serif;
        border: none;
        outline: none;
        background-color: #fff;
    }
`;

const LocationFilter = () => {
    return (
        <LocationFilterWrap>
            <HighlightBorder />
            <LocationFilterBtn>
                <select name='지역'>
                    <option value='Seattle'>Seattle</option>
                </select>
            </LocationFilterBtn>
        </LocationFilterWrap>
    )
}

export default LocationFilter
