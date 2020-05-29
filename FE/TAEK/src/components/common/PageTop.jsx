import React from 'react'
import styled from 'styled-components';

const PageTopWrap = styled.div`
    .page-top-button {
        width: 30px;
        height: 30px;
        border: 1.19px solid #7f8c8d99;
        box-shadow: ${(props) => props.theme.boxShadow};
        border-radius: 50%;
        position: fixed;
        bottom: 30px;
        right: 30px;
        text-align: center;
        line-height: 28px;
        color: #c2c2c2;
        transform: rotate(-90deg);
    }
`;

const PageTop = () => {
    const handleMovePageTop = () => window.scrollTo(0, 0);

    return (
        <PageTopWrap>
            <div className='page-top-button' onClick={handleMovePageTop}>➤</div>
        </PageTopWrap>
    )
}

export default PageTop
