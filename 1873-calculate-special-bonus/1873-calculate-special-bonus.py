import pandas as pd

def calculate_special_bonus(df: pd.DataFrame) -> pd.DataFrame:
    
    df['bonus'] = 0

    mask = (df['employee_id'] % 2 != 0) & ~df['name'].str.startswith('M')

    df.loc[mask, 'bonus'] = df.loc[mask, 'salary']

    return df[['employee_id', 'bonus']].sort_values(by = 'employee_id')

