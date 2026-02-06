import pytest
from login import login


def test_valid_credentials():
    assert login("admin", "1234") == "Success"


def test_invalid_username():
    assert login("user", "1234") == "Fail"


def test_invalid_password():
    assert login("admin", "0000") == "Fail"


def test_both_invalid():
    assert login("user", "pass") == "Fail"


def test_empty_username():
    assert login("", "1234") == "Fail"


def test_empty_password():
    assert login("admin", "") == "Fail"
