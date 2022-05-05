/*
 * Copyright © 2022 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.e2e.pages.actions;

import io.cdap.e2e.pages.locators.HdfSignInLocator;
import io.cdap.e2e.utils.ElementHelper;
import io.cdap.e2e.utils.SeleniumHelper;

import java.io.IOException;

import static io.cdap.e2e.utils.ConstantsUtil.HDFPAZWRD;
import static io.cdap.e2e.utils.ConstantsUtil.HDFUSERNAME;

/**
 * Represents HdfSignInActions
 */
public class HdfSignInActions {
  public static HdfSignInLocator hdfSignInLocator;
  private static boolean logged = false;

  static {
    hdfSignInLocator = SeleniumHelper.getPropertiesLocators(HdfSignInLocator.class);
  }

  public static boolean logged() {
    return logged;
  }

  public static void login() throws InterruptedException, IOException {
    ElementHelper.sendKeys(hdfSignInLocator.hdfUsername, SeleniumHelper.readParameters(HDFUSERNAME));
    ElementHelper.sendKeys(hdfSignInLocator.hdfPassword, SeleniumHelper.readParameters(HDFPAZWRD));
    ElementHelper.clickOnElement(hdfSignInLocator.loginButton);
    logged = true;
  }
}
