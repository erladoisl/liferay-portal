/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.user.associated.data.internal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.user.associated.data.util.UADAnonymizerHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Drew Brokke
 */
@Component(immediate = true, service = UADAnonymizerHelper.class)
public class UADAnonymizerHelperImpl implements UADAnonymizerHelper {

	@Override
	public User getAnonymousUser() throws PortalException {
		return _userLocalService.getDefaultUser(
			CompanyThreadLocal.getCompanyId());
	}

	@Override
	public long getAnonymousUserId() throws PortalException {
		User anonymousUser = getAnonymousUser();

		return anonymousUser.getUserId();
	}

	@Reference
	private UserLocalService _userLocalService;

}