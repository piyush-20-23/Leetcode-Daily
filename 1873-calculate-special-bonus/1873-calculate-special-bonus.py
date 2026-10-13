import pandas as pd
import numpy as np

def calculate_special_bonus(df: pd.DataFrame) -> pd.DataFrame:
    
    clean = (df['employee_id']%2 == 1) & ~(df['name'].str.startswith('M'))
    df['bonus'] = np.where(clean, df['salary'], 0)
    return df[['employee_id', 'bonus']].sort_values(by = 'employee_id')