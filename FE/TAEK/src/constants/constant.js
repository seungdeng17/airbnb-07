const MAIN = {
    DATE: {
        DATE_FORMAT: 'MMM D일',
        START_DATE_TEXT: '체크인',
        START_DATE_ID: 'airbnb-start-date',
        END_DATE_TEXT: '체크아웃',
        END_DATE_ID: 'airbnb-end-date',
    },
    PERSON: {
        ADULT: {
            TEXT: '어른',
            DESC: '만 13세 이상',
            COUNT_TYPE: { countType: 'adultCount' },
        },
        CHILD: {
            TEXT: '어린이',
            DESC: '2 ~ 12세',
            COUNT_TYPE: { countType: 'childCount' },
        },
        BABY: {
            TEXT: '유아',
            DESC: '2세 미만',
            COUNT_TYPE: { countType: 'babyCount' },
        },
    },
    CHARGE: {
        MIN_CHARGE: 12000,
        MAX_CHARGE: 1000000,
    }
}

export {
    MAIN
}