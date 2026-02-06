def calculate_discount(price, percentage): 
    """Calculate the discount amount based on price and percentage."""
    if price < 0 or percentage < 0:
        raise ValueError("Price and percentage must be non-negative.")
    return price * (percentage / 100)

